package com.tigerspike.mapper;

public interface DataMapper<DATA, MODEL> {


    MODEL transform(DATA data);


}
