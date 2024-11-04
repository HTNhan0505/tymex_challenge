


import Foundation

@MainActor
class CurrencyViewModel : ObservableObject {
    @Published var amount : String = ""
    
    @Published var baseCurrency : String = "USD"
    
    @Published var targetCurrency : String = "VND"
    
    @Published var decimalPlaces : Int = 2
    
    @Published var convertAmount : String = ""
    @Published var exchangeRates : [String: Double] = [:]
    
    @Published var isloading : Bool = false
    
    @Published var errorMessage : String? = nil
    
    private let apiKey = "8c29cd5ee5c64263e9d23820965d220d"
    
    private var baseUrl = "https://api.exchangeratesapi.io/latest"
    
    init() {
        Task {
            await getExchangeRates()
        }
    }
    
    
    func getExchangeRates() async {
        isloading = true
        errorMessage = nil
        
        let urlString = "\(baseUrl)?access_key=\(apiKey)"
        
        print(urlString)
        guard let url = URL(string: urlString) else {
            errorMessage = "Invalid URL"
            isloading = false
            return
        }
        
        do {
            let (data,_) = try await URLSession.shared.data(from: url)
            
            let result = try JSONDecoder().decode(CurrencyResponse.self,from: data)
            
            
            exchangeRates = result.rates
        } catch {
            
            errorMessage = "Failed to get rates: \(error.localizedDescription)"
        }
        
        isloading = false
        
    }
    
    
    func convertCurrency() {
        guard let amountValue = Double(amount) else {
            errorMessage = "Please enter a valid number amount"
            return
        }
        
        guard baseCurrency != targetCurrency else {
            errorMessage = "Please choose two different currencies."
            return
        }
        guard let baseRate = exchangeRates[baseCurrency],
              let target = exchangeRates[targetCurrency] else {
            errorMessage = "Conversion rate unavailable."
            return
        }
        
        
        let rate = target / baseRate
        let result = amountValue * rate
        
        let formatter = NumberFormatter()
        formatter.numberStyle = .decimal
        formatter.minimumFractionDigits = decimalPlaces
        formatter.maximumFractionDigits = decimalPlaces
        formatter.groupingSeparator = ","
        formatter.decimalSeparator = "."
        
        convertAmount = formatter.string(from: NSNumber(value: result)) ?? "--"
        
        errorMessage = nil
    }
    
    
}
