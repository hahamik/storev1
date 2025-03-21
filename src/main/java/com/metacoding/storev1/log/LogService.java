package com.metacoding.storev1.log;

import java.util.List;

import org.springframework.stereotype.Service;

import com.metacoding.storev1.log.LogResponse.ListPage;

@Service
public class LogService {

    private LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public List<ListPage> 구매목록() {
        return logRepository.findAllJoinStore();
    }

    // @Transactional
    // public void 상품구매(int buy, int qty) {
    // Log log = logRepository.findById(id);
    // if (log == null) {
    // throw new RuntimeException("구매할 수 없는 상품");
    // }
    // logRepository.update(id, name, stock, price);
    // }
}
