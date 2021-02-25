
package com.example.demo.service.random;

import com.example.demo.entity.random.RandomNumber;

//    db제어 할 필요가 없어 throws Exception 처리를 할 필요가 없음
public interface RandomNumberService {
    public RandomNumber getRandom();
}