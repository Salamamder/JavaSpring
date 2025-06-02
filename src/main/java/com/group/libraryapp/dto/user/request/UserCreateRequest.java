package com.group.libraryapp.dto.user.request;

public class UserCreateRequest {

    private String name;
    private Integer age; // Integer은 null을 표현 가능함, int는 null을 표현 못함
    // 요청사항에 나이는 null이 올 수 있도록 부탁했음


    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
