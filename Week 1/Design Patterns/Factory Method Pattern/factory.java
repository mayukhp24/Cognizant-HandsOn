interface Document {
    void open();
}

class WordDocument implements Document {
    public void open() {
        System.out.println("Opening a Word document");
    }
}

class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening a PDF document");
    }
}

class ExcelDocument implements Document {
    public void open() {
        System.out.println("Opening an Excel document");
    }
}

abstract class DocumentFactory {
    public abstract Document createDocument();
}

class WordFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDocument();
    }
}

public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        DocumentFactory factory = new WordFactory();
        Document doc = factory.createDocument();
        doc.open();

        factory = new PdfFactory();
        doc = factory.createDocument();
        doc.open();

        factory = new ExcelFactory();
        doc = factory.createDocument();
        doc.open();
    }
}
