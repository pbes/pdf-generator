package hu.pbes.pdfgenerator.action;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.thymeleaf.TemplateEngine;

import java.io.ByteArrayOutputStream;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GeneratePdfAction {

    private final TemplateEngine templateEngine;

    public byte[] invoke(String template, Map<String, Object> data) {
        final var html = generateHtmlFromTemplate(template, data);
        return generatePdfFromHtml(html);
    }

    private String generateHtmlFromTemplate(String template, Map<String, Object> data) {
        final var  context = new Context();
        context.setVariables(data);

        return templateEngine.process(template, context);
    }

    private byte[] generatePdfFromHtml(String html) {
        try (final var outputStream = new ByteArrayOutputStream()) {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(html);
            renderer.layout();
            renderer.createPDF(outputStream);
            return outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
