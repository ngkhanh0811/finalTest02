package com.example.finaltest02;/*Welcome to my show !

@author: NgKhanh
Date: 6/14/2023
Time: 7:04 PM

ProjectName: jpa_sem4*/

import java.util.List;

public interface JpaExecutors<T> {
    List<T> findall();
    T getById(String id);
}
