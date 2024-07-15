package com.stockanalysis.ui;

import com.stockanalysis.api.MarketstackAPI;
import com.stockanalysis.database.DatabaseManager;
import com.stockanalysis.analysis.HigherTimeFrameAnalyzer;
import com.stockanalysis.analysis.LowerTimeFrameAnalyzer;

import java.util.Scanner;

public class CLI {
    private final MarketstackAPI api;
    private final DatabaseManager dbManager;
    private final HigherTimeFrameAnalyzer htfAnalyzer;
    private final LowerTimeFrameAnalyzer ltfAnalyzer;

    public CLI(MarketstackAPI api, DatabaseManager dbManager, HigherTimeFrameAnalyzer htfAnalyzer, LowerTimeFrameAnalyzer ltfAnalyzer) {
        this.api = api;
        this.dbManager = dbManager;
        this.htfAnalyzer = htfAnalyzer;
        this.ltfAnalyzer = ltfAnalyzer;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Stock Analysis Tool");
            System.out.println("1. Fetch Stock Data");
            System.out.println("2. Analyze Market Bias");
            System.out.println("3. Detect SMT Divergence");
            System.out.println("4. Detect Inverse Fair Value Gap Retrace");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    fetchStockData(scanner);
                    break;
                case 2:
                    analyzeMarketBias(scanner);
                    break;
                case 3:
                    detectSMTDivergence(scanner);
                    break;
                case 4:
                    detectInverseFairValueGapRetrace(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void fetchStockData(Scanner scanner) {
        System.out.print("Enter stock symbol: ");
        String symbol = scanner.nextLine();
        System.out.print("Enter interval (e.g., 1h, 1d): ");
        String interval = scanner.nextLine();
        
        try {
            String data = api.fetchStockData(symbol, interval);
            System.out.println("Fetched data: " + data);
            // TODO: Parse JSON and store in database
        } catch (Exception e) {
            System.out.println("Error fetching stock data: " + e.getMessage());
        }
    }

    private void analyzeMarketBias(Scanner scanner) {
        System.out.print("Enter stock symbol: ");
        String symbol = scanner.nextLine();
        
        String bias = htfAnalyzer.analyzeMarketBias(symbol);
        System.out.println("Market bias for " + symbol + ": " + bias);
    }

    private void detectSMTDivergence(Scanner scanner) {
        System.out.print("Enter stock symbol: ");
        String symbol = scanner.nextLine();
        
        boolean divergence = ltfAnalyzer.detectSMTDivergence(symbol);
        System.out.println("SMT Divergence detected for " + symbol + ": " + divergence);
    }

    private void detectInverseFairValueGapRetrace(Scanner scanner) {
        System.out.print("Enter stock symbol: ");
        String symbol = scanner.nextLine();
        
        boolean retrace = ltfAnalyzer.detectInverseFairValueGapRetrace(symbol);
        System.out.println("Inverse Fair Value Gap Retrace detected for " + symbol + ": " + retrace);
    }
}