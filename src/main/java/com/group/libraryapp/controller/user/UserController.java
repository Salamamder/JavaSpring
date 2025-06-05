package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.fruit.FruitService;
import com.group.libraryapp.service.user.UserServiceV1;
import com.group.libraryapp.service.user.UserServiceV2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // api설정
// usercontroller를 스프링 빈으로 등록시켜주는 역할을 한다.
// 스프링 빈 안에 jdbcTemplate도 들어가 있음
// 해당 restcontroller 덕분에 get 요청으로 자료 조회시
// json형태로 자료를 반환해준다
public class UserController {

    private final UserServiceV2 userService;
    private final FruitService fruitService;

    public UserController(UserServiceV2 userService, @Qualifier("appleService") FruitService fruitService) {
        this.userService = userService;
        this.fruitService = fruitService;
    }

    //    @GetMapping("/user")
//    public List<UserResponse> getUsers() {
//        String sql = "SELECT * FROM user";
//        return jdbcTemplate.query(sql, new RowMapper<UserResponse>() {
//            @Override
//            public UserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
//                long id = rs.getLong("id");
//                String name = rs.getString("name");
//                int age = rs.getInt("age");
//                return new UserResponse(id, name, age);
//            }
//        });
//    }
    // C R U D 구현
    @PostMapping("/user") // POST /user
    public void saveUser(@RequestBody UserCreateRequest request) {
        userService.saveUser(request);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }


    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        userService.updateUser(request);

    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
        userService.deleteUser(name);
    }

}
