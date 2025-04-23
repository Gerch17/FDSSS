package ru.tbank.fdsspring.job;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.tbank.fdsspring.model.CurrencyRateDto;
import ru.tbank.fdsspring.service.CbrClient;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CurrencyRateJob {

    private final CbrClient cbrClient;

    @Scheduled(cron = "0 0 * * *")
    public void fetchAndPrintRates() {
        List<CurrencyRateDto> rates = cbrClient.fetchRates();
        rates.forEach(System.out::println);
    }
}
