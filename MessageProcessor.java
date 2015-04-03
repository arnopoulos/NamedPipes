public class MessageProcessor<D> {
	private Mapper<D> mapper = null;
	private MessageContainer<D> container = null;

	public MessageProcessor(Mapper<D> mapper, MessageContainer<D> container) {
		this.mapper = mapper;
		this.container = container;
	}

	public void process() {
		D mapping = this.mapper.apply(container.getData());
		// System.out.println(this.mapper);
		MessageSender<D> sender = container.getSender();
		sender.sendMessage(mapping);
	}
}