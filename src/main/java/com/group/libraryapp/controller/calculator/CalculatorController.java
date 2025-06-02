package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // api를 개발하려는 클래스에 적어줘야 하는거임
// api의 진입지점을 만들어주는 역할을 한다
public class CalculatorController {
    // 덧셈 API

    @GetMapping("/add") // GET/add
    public int addTwoNumbers(CalculatorAddRequest request) {
        // @RequestParam : 쿼리를 통해서 넘어온 데이터를 받도록 함
        return request.getNumber1() + request.getNumber2();
    }
}

// Get/add?number1=10&number2=20 : 대충 이런식으로 넘어오면 이를 받아서 처리할 수 있도록 만든 것
