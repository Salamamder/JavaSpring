package com.group.libraryapp.dto.calculator.request;

public class CalculatorAddRequest {
// final을 써도 문제 없다함 -> 요청이 있을 때마다 객체가 새로 생성되는 형태기 때문
    // 새로 생성된 객체에 final을 처음부터 정한다 -> 그래서 문제 없음
    // DTO : Data Transfer Object
    private final int number1;
    private final int number2;

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public CalculatorAddRequest(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }
}
