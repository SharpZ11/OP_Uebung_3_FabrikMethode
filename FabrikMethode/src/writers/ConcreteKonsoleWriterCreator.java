package writers;

public class ConcreteKonsoleWriterCreator extends WriterCreator {

	@Override
	public WriterProduct factoryMethod() {
		return new ConcreteKonsoleWriterProduct();
	}

}
