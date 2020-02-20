package grabl.tracing.client;

import java.util.UUID;

/**
 * A simple no-operation GrablTracing.
 *
 * Uses the Bill Pugh method of lazy singleton instantiation.
 */
class NoOpGrablTracing implements GrablTracing {

    private NoOpGrablTracing() {
    }

    private static class LazyHolder {
        private static final NoOpGrablTracing TRACING = new NoOpGrablTracing();
        private static final TraceImpl TRACE = new TraceImpl();
        private static final AnalysisImpl ANALYSIS = new AnalysisImpl();
    }

    static GrablTracing getInstance() {
        return LazyHolder.TRACING;
    }

    @Override
    public Trace trace(UUID rootId, UUID parentId, String name) {
        return LazyHolder.TRACE;
    }

    @Override
    public Analysis analysis(String owner, String repo, String commit) {
        return LazyHolder.ANALYSIS;
    }

    @Override
    public void close() {

    }

    private static class TraceImpl implements Trace {

        @Override
        public Trace trace(String name) {
            return LazyHolder.TRACE;
        }

        @Override
        public Trace data(String data) {
            return LazyHolder.TRACE;
        }

        @Override
        public Trace labels(String... labels) {
            return LazyHolder.TRACE;
        }

        @Override
        public Trace end() {
            return LazyHolder.TRACE;
        }

        @Override
        public UUID getRootId() {
            return null;
        }

        @Override
        public UUID getId() {
            return null;
        }
    }

    private static class AnalysisImpl implements Analysis {

        @Override
        public Trace trace(String name, String tracker, int iteration) {
            return LazyHolder.TRACE;
        }
    }
}
