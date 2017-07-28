package com.example.ecommerce.base;

import io.reactivex.functions.Consumer;

/**
 * Created by Harry on 2/21/17.
 */

public abstract class DataConsumer<V> implements Consumer<V> {

    @Override
    public void accept(V d) throws Exception {
        if (d != null) {
            onData(d);
        }
    }

    public abstract void onData(V data);
}
