@RestController
@RequestMapping("/api")
public class StockResource {

    private final StockService stockService;

    public StockResource(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/stocks/{symbol}")
    public ResponseEntity<Stock> getStock(@PathVariable String symbol) {
        Stock stock = stockService.getStockBySymbol(symbol);
        return ResponseEntity.ok(stock);
    }
}
