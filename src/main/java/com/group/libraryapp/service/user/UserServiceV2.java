package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {
    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 아래 있는 함수가 시작될 때 start transaction;을 해준다. (트랜잭션을 시작해준다.)
    // 함수가 예외없이 잘 끝나면 commit;
    // 혹시라도 문제가 생기면 rollback을 하게 된다.
    // IOException(체크예외)는 발생해도 롤백이 되지 않음 ->
    @Transactional
    public void saveUser(UserCreateRequest request) {
        User u = userRepository.save(new User(request.getName(), request.getAge()));
        u.getId(); // ex) 1, 2, 3
    }
    @Transactional(readOnly = true) // readOnly를 활성화 -> 데이터 변경 기능 제한으로 성능적 이점 존재
    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());

    }
    @Transactional
    public void updateUser(UserUpdateRequest request) {
        // select * from user where id = ?;
        // Optional<User>
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalAccessError::new);

        // jpa를 통해 sql쿼리 작성 없이 내용 업데이트
        user.updateName(request.getName());
        userRepository.save(user);
    }
    @Transactional
    public void deleteUser(String name) {
        // select * from user where name = ?
//        User user = userRepository.findByName(name)
//                .orElseThrow(IllegalAccessError::new);
//      userRepository.delete(user);
        if (!userRepository.existsByName(name)) {
            throw new IllegalArgumentException();
        }
        User user = userRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없음"));
        userRepository.delete(user);


    }
}
