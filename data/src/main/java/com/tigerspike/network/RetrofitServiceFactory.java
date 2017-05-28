package com.tigerspike.network;

public interface RetrofitServiceFactory {

    <T> T getService(Class<T> service);
}
