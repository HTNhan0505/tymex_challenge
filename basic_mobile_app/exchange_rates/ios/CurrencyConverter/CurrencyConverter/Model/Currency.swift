
import SwiftUI

struct Currency : Identifiable {
    var id = UUID().uuidString
    var currencyName: String
    var currencyValue: Double
}
