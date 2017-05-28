package com.tigerspike.network;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;


public class ConfigurableRetrofitServiceFactory implements RetrofitServiceFactory {

    private static final String CONTENT_ENTITY_TYPE = "ContentEntity-Type";
    private static final String APPLICATION_SOAP_XML = "application/soap+xml";
    private static final String ACCEPT_CHARSET = "Accept-Charset";
    private static final String UTF_8 = "UTF-8";

    private okhttp3.OkHttpClient.Builder clientBuilder;

    @Inject
    public ConfigurableRetrofitServiceFactory() {
        clientBuilder = new okhttp3.OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        clientBuilder.addInterceptor(logging);


        clientBuilder.interceptors().add(addRequestInterceptor());

    }

    private Interceptor addRequestInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                Request.Builder builder = original.newBuilder()
                        .header(CONTENT_ENTITY_TYPE, APPLICATION_SOAP_XML)
                        .header(ACCEPT_CHARSET, UTF_8);

                Request request = builder.method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        };
    }

    @Override
    public <T> T getService(Class<T> service) {

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(HttpConstants.BASE_URL)
                .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .client(clientBuilder.build())
                .build();

        return builder.build().create(service);
    }
}
