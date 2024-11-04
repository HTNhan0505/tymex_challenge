

import SwiftUI

struct ContentView: View {
    @StateObject private var viewModel = CurrencyViewModel()
    var body: some View {
        VStack(spacing:20) {
            Text("Currency Converter")
                .font(.largeTitle)
                .fontWeight(.bold)
            
            TextField("Enter amount",text: $viewModel.amount)
                .textFieldStyle(.roundedBorder)
                .font(.title3)
                .keyboardType(.decimalPad)
                .padding(.horizontal)
            
            HStack{
                Text("From:")
                Picker("Base Currency",selection:$viewModel.baseCurrency) {
                    ForEach(Array(viewModel.exchangeRates.keys),id :\.self) {
                        currency in
                        Text(currency)
                    }
                }
                .pickerStyle(.menu)
            }
            .padding(.horizontal)
            
            HStack{
                Text("To:")
                Picker("TargetCurrency",selection: $viewModel.targetCurrency) {
                    ForEach(Array(viewModel.exchangeRates.keys),id: \.self) {
                        currency in
                        Text(currency)
                    }
                }
                
                .pickerStyle(.menu)
            }
            .padding(.horizontal)
            
            VStack {
                Text("Decimal Precision: \(viewModel.decimalPlaces)")
                Slider(value: Binding(
                    get: {
                        Double(viewModel.decimalPlaces)
                    },set: {
                        viewModel.decimalPlaces = Int($0)
                    }
                ),in: 0...4,step: 1)
            }
            .padding(.horizontal)
            
            Button( action: {
                viewModel.convertCurrency()
            },label: {
                Text("Convert")
                    .font(.title2)
                    .fontWeight(.semibold)
                    .frame(maxWidth: .infinity)
                    .padding()
                    .background(Color.blue)
                    .foregroundStyle(.white)
                    .cornerRadius(10)
            }
            ).padding(.horizontal)
            
            
            if !viewModel.convertAmount.isEmpty {
                Text("Converted amount : \(viewModel.convertAmount)")
                    .font(.title2)
                    .fontWeight(.medium)
                    .padding()
            }
            
            if let errorMessage = viewModel.errorMessage {
                Text(errorMessage)
                    .foregroundStyle(.red)
                    .padding()
            }
            if viewModel.isloading{
                ProgressView("Getting rates .....")
            }
        }
    }
}

#Preview {
    ContentView()
}
