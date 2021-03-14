public class W5_Final{
    //ex >> String Class 는  final 로 이루어져 있음
    //왜 final 로 클래스의 상속을 막았냐면, 자바언에에서 의도한대로 동작해야하는데
    // 자바클래스 상속을 막는경우는 상속이 부적절할때

    
        private final String streamName;
        private final long version;
    
        public EventStreamId(String streamName, long version) {
            this.streamName = streamName;
            this.version = version;
        }
    
        public EventStreamId(String streamName) {
            this(streamName, 1L);
        }
    
        public EventStreamId withVersion(long version) {
            return new EventStreamId(this.getStreamName(), version);
        }

}
