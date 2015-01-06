package com.ixi.ceti.expiringmap;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * NamedThreadFactory.
 * Created by Anup Dixit on july 15, 2014.
 */
public class NamedThreadFactory implements ThreadFactory {

    private final AtomicInteger threadNumber = new AtomicInteger(1);

    private final String nameFormat;

    /**
     * Creates a thread factory that names threads according to the
     * {@code nameFormat} by supplying a single argument to the
     * format representing the thread number.
     */
    public NamedThreadFactory(String nameFormat) {
        this.nameFormat = nameFormat;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, String.format(nameFormat, threadNumber.getAndIncrement()));
    }
}
