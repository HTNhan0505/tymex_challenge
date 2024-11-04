

import SwiftUI

struct Conversion: Decodable {
    var rates : [String: Double]
    
    var date: String
    var base : String
    
}
