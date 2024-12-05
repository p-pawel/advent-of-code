package aoc.year2024.day05.part01;

import aoc.year2024.day05.part01.adapters.ScannerAdapter;
import aoc.year2024.day05.part01.adapters.StringToPageOrderingMapper;
import aoc.year2024.day05.part01.adapters.StringToPagesToProduceMapper;
import aoc.year2024.day05.part01.domain.PageOrderingRule;
import aoc.year2024.day05.part01.domain.PagesToProduce;
import aoc.year2024.day05.part01.repositories.PageOrderingRepository;
import aoc.year2024.day05.part01.services.PageMatchService;
import aoc.year2024.day05.part01.services.PageReorderService;

import java.util.List;
import java.util.Scanner;

public class PrintQueueEnterpriseEditionApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<PageOrderingRule> rules = new ScannerAdapter<PageOrderingRule>().read(scanner, new StringToPageOrderingMapper()::parse);
        List<PagesToProduce> pages = new ScannerAdapter<PagesToProduce>().read(scanner, new StringToPagesToProduceMapper()::parse);
        scanner.close();

        PageOrderingRepository pageOrderingRepository = new PageOrderingRepository();
        pageOrderingRepository.saveAll(rules);
        
        PageMatchService pageMatchService = new PageMatchService(pageOrderingRepository);
        PageReorderService pageReorderService = new PageReorderService(pageOrderingRepository);
        
        Part01Calculator part01Calculator = new Part01Calculator(pageMatchService);
        Part02Calculator part02Calculator = new Part02Calculator(pageMatchService, pageReorderService);
        
        System.out.println("Part 1: " + part01Calculator.calculate(pages));
        System.out.println("Part 2: " + part02Calculator.calculate(pages));
    }


    
}

