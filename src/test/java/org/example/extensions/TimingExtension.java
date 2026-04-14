package org.example.extensions;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TimingExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {
    private static final String START_TIME = "startTime";
    private static final long TIME_LIMIT = 500;

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        System.out.printf("%nTest %s started", context.getDisplayName());
        context.getStore(ExtensionContext.Namespace.GLOBAL).put(START_TIME, System.currentTimeMillis());
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        long startTime = context.getStore(ExtensionContext.Namespace.GLOBAL).remove(START_TIME, long.class);
        long duration = System.currentTimeMillis() - startTime;
        System.out.printf("Test %s took %s ms%n", context.getDisplayName(), duration);

        if (duration > TIME_LIMIT) {
            System.out.printf("Waring: Test %s exceeded the time limit of %s ms. Actual time taken: %s ms%n",
                    context.getDisplayName(), TIME_LIMIT, duration);
        }
    }
}
