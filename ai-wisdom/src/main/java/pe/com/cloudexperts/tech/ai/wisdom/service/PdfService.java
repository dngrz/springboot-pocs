package pe.com.cloudexperts.tech.ai.wisdom.service;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.reader.ExtractedTextFormatter;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.reader.pdf.config.PdfDocumentReaderConfig;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cloudexperts.tech.ai.wisdom.config.DataConfiguration;

@Service
@Slf4j
public class PdfService {

  @Autowired
  private VectorStore vectorStore;

  @Autowired
  private DataConfiguration dataConfiguration;

  public void process() throws IOException {

    var config = PdfDocumentReaderConfig
        .builder()
        .withPageExtractedTextFormatter(new ExtractedTextFormatter.Builder()
            .withNumberOfBottomTextLinesToDelete(3)
            .build())
        .build();

    var pdfReader = new PagePdfDocumentReader( dataConfiguration.getDataPdf(), config);

    var splitter = new TokenTextSplitter();

    var docs = splitter.apply(pdfReader.get());

    vectorStore.accept(docs);

    log.info("finish pdf process");
  }
}
