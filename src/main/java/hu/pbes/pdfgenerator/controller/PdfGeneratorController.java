package hu.pbes.pdfgenerator.controller;

import hu.pbes.pdfgenerator.action.GeneratePdfAction;
import hu.pbes.pdfgenerator.dto.GenerateRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PdfGeneratorController {

    private final GeneratePdfAction generatePdfAction;

    public Mono<ServerResponse> generatePdf(ServerRequest request) {
        final var requestMono = request.bodyToMono(GenerateRequestDTO.class);
        return requestMono.flatMap(req -> {
            final var pdf = generatePdfAction.invoke(req.getTemplate(), req.getData());
            return ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_PDF)
                    .bodyValue(pdf);
        });
    }

}
