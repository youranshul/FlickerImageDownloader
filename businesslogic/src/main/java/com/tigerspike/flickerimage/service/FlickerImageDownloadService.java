package com.tigerspike.flickerimage.service;

import com.tigerspike.flickerimage.model.FlickerImageData;

import io.reactivex.Observable;

public interface FlickerImageDownloadService {

    Observable<FlickerImageData> downloadImages();
}
