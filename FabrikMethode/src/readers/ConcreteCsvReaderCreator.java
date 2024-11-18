package readers;

import java.io.IOException;

public class ConcreteCsvReaderCreator extends ReaderCreator {

	@Override
	public ReaderProduct factoryMethod() {	
		try {
			return new ConcreteCsvReaderProduct();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		
	}

}
