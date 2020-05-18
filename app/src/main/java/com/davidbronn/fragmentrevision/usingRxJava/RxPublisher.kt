package com.davidbronn.fragmentrevision.usingRxJava

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

/**
 * Created by Jude on 18/May/2020
 */
class RxPublisher private constructor() {

    private val subject = PublishSubject.create<RxEvent>()

    fun publish(event: RxEvent) {
        subject.onNext(event)
    }

    fun listen(): Observable<RxEvent?>? {
        return subject
    }

    companion object {
        private var instance: RxPublisher? = null

        fun getInstance(): RxPublisher? {
            if (instance == null) {
                instance = RxPublisher()
            }
            return instance
        }
    }
}