package com.fiap.card.batch.skipping;

import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.batch.core.step.skip.SkipPolicy;
import org.springframework.batch.item.file.transform.IncorrectLineLengthException;

public class CustomSkipPolicy implements SkipPolicy {

    @Override
    public boolean shouldSkip(Throwable throwable, int skipCount)
            throws SkipLimitExceededException {

        if (throwable.getCause() instanceof IncorrectLineLengthException) {
            return true;
        }

        return false;
    }
}
