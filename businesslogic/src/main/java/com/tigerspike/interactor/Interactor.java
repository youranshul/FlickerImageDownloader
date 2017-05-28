package com.tigerspike.interactor;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class Interactor<T, PARAMS> {

    private static final String TAG = Interactor.class.getSimpleName();
    private final PostExecutionThread postExecutionThread;
    private final CompositeDisposable disposables;

    public Interactor(PostExecutionThread postExecutionThread) {
        this.postExecutionThread = postExecutionThread;
        this.disposables = new CompositeDisposable();
    }


    public abstract Observable<T> buildUseCase(PARAMS params);

    public void execute(DisposableObserver<T> observer, PARAMS params) {
        final Observable<T> observable = this.buildUseCase(params)
                .subscribeOn(Schedulers.io())
                .observeOn(postExecutionThread.getScheduler());

        if (observer != null) {
            addDisposable(observable.subscribeWith(observer));
        }
    }

    /**
     * Dispose from current {@link CompositeDisposable}.
     */
    public void dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    private void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }

}
