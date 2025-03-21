package com.metacoding.storev1.log;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.metacoding.storev1.log.LogResponse.ListPage;

@Import(LogRepository.class)
@DataJpaTest // EM IOC 등록
public class LogRepositoryTest {

    // ioc에 있는 걸 DI 방법 두가지
    // 1. 생성자로 주입
    // 2. Autowired 어노테이션으로 di하는 방법
    @Autowired
    private LogRepository logRepository;

    // test할 때만 언더바 사용함
    @Test
    public void findAllJoinStore_test() { // 매개변수에 아무것도 넣을 수 없음 -> 문법
        List<LogResponse.ListPage> logList = logRepository.findAllJoinStore();
        for (ListPage listPage : logList) {
            System.out.println(listPage);
        }
    }
}
