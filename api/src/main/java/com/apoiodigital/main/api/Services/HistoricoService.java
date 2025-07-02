package com.apoiodigital.main.api.Services;

import com.apoiodigital.main.api.Models.Requisicao;
import com.apoiodigital.main.api.Models.Resposta;
import com.apoiodigital.main.api.Models.Historico;
import com.apoiodigital.main.api.Repositories.HistoricoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class HistoricoService {

    private final HistoricoRepository respostaPhotoRepository;

    public HistoricoService(HistoricoRepository respostaPhotoRepository) {
        this.respostaPhotoRepository = respostaPhotoRepository;
    }

    public Historico salvarPrintScreen(MultipartFile printScreen, Resposta resposta) throws IOException {
        var respostaPrintScreen = new Historico();
        var id = respostaPhotoRepository.count() + 1;

        if(printScreen != null && !printScreen.isEmpty()){
            String base64Imagem = Base64.getEncoder().encodeToString(printScreen.getBytes());
            respostaPrintScreen.setPrintScreen(base64Imagem);
            respostaPrintScreen.setId(id);
            respostaPrintScreen.setResposta(resposta);
            respostaPrintScreen.setRequisicao(resposta.getRequsicao());
            return respostaPhotoRepository.save(respostaPrintScreen);
        }
        return null;
    }

    public List<Historico> carregarPelaRequisicao(Requisicao requisicao){
        return respostaPhotoRepository.findRespostaPrintScreenByRequisicao(requisicao);
    }




}
