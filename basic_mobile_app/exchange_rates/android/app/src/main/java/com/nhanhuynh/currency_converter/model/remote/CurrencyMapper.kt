package com.nhanhuynh.currency_converter.remote

import com.nhanhuynh.currency_converter.model.remote.CurrencyData


fun CurrencyData.toCurrencyRates(): List<CurrencyRate> {

    val currencyData = this.rates

    return listOf(
        CurrencyRate("AED", "United Arab Emirates Dirham", currencyData.AED),
        CurrencyRate("AFN", "Afghan Afghani", currencyData.AFN),
        CurrencyRate("ALL", "Albanian Lek", currencyData.ALL),
        CurrencyRate("AMD", "Armenian Dram", currencyData.AMD),
        CurrencyRate("ANG", "Netherlands Antillean Guilder", currencyData.ANG),
        CurrencyRate("AOA", "Angolan Kwanza", currencyData.AOA),
        CurrencyRate("ARS", "Argentine Peso", currencyData.ARS),
        CurrencyRate("AUD", "Australian Dollar", currencyData.AUD),
        CurrencyRate("AWG", "Aruban Florin", currencyData.AWG),
        CurrencyRate("AZN", "Azerbaijani Manat", currencyData.AZN),
        CurrencyRate("BAM", "Bosnia and Herzegovina Convertible Mark", currencyData.BAM),
        CurrencyRate("BBD", "Barbadian Dollar", currencyData.BBD),
        CurrencyRate("BDT", "Bangladeshi Taka", currencyData.BDT),
        CurrencyRate("BGN", "Bulgarian Lev", currencyData.BGN),
        CurrencyRate("BHD", "Bahraini Dinar", currencyData.BHD),
        CurrencyRate("BIF", "Burundian Franc", currencyData.BIF),
        CurrencyRate("BMD", "Bermudian Dollar", currencyData.BMD),
        CurrencyRate("BND", "Brunei Dollar", currencyData.BND),
        CurrencyRate("BOB", "Bolivian Boliviano", currencyData.BOB),
        CurrencyRate("BRL", "Brazilian Real", currencyData.BRL),
        CurrencyRate("BSD", "Bahamian Dollar", currencyData.BSD),
        CurrencyRate("BTC", "Bitcoin", currencyData.BTC),
        CurrencyRate("BTN", "Bhutanese Ngultrum", currencyData.BTN),
        CurrencyRate("BWP", "Botswana Pula", currencyData.BWP),
        CurrencyRate("BYN", "Belarusian Ruble", currencyData.BYN),
        CurrencyRate("BYR", "Belarusian Ruble (pre-2016)", currencyData.BYR),
        CurrencyRate("BZD", "Belize Dollar", currencyData.BZD),
        CurrencyRate("CAD", "Canadian Dollar", currencyData.CAD),
        CurrencyRate("CDF", "Congolese Franc", currencyData.CDF),
        CurrencyRate("CHF", "Swiss Franc", currencyData.CHF),
        CurrencyRate("CLF", "Chilean Unit of Account (UF)", currencyData.CLF),
        CurrencyRate("CLP", "Chilean Peso", currencyData.CLP),
        CurrencyRate("CNH", "Chinese Yuan (Offshore)", currencyData.CNH),
        CurrencyRate("CNY", "Chinese Yuan", currencyData.CNY),
        CurrencyRate("COP", "Colombian Peso", currencyData.COP),
        CurrencyRate("CRC", "Costa Rican Colón", currencyData.CRC),
        CurrencyRate("CUC", "Cuban Convertible Peso", currencyData.CUC),
        CurrencyRate("CUP", "Cuban Peso", currencyData.CUP),
        CurrencyRate("CVE", "Cape Verdean Escudo", currencyData.CVE),
        CurrencyRate("CZK", "Czech Koruna", currencyData.CZK),
        CurrencyRate("DJF", "Djiboutian Franc", currencyData.DJF),
        CurrencyRate("DKK", "Danish Krone", currencyData.DKK),
        CurrencyRate("DOP", "Dominican Peso", currencyData.DOP),
        CurrencyRate("DZD", "Algerian Dinar", currencyData.DZD),
        CurrencyRate("EGP", "Egyptian Pound", currencyData.EGP),
        CurrencyRate("ERN", "Eritrean Nakfa", currencyData.ERN),
        CurrencyRate("ETB", "Ethiopian Birr", currencyData.ETB),
        CurrencyRate("EUR", "Euro", currencyData.EUR),
        CurrencyRate("FJD", "Fijian Dollar", currencyData.FJD),
        CurrencyRate("FKP", "Falkland Islands Pound", currencyData.FKP),
        CurrencyRate("GBP", "British Pound Sterling", currencyData.GBP),
        CurrencyRate("GEL", "Georgian Lari", currencyData.GEL),
        CurrencyRate("GGP", "Guernsey Pound", currencyData.GGP),
        CurrencyRate("GHS", "Ghanaian Cedi", currencyData.GHS),
        CurrencyRate("GIP", "Gibraltar Pound", currencyData.GIP),
        CurrencyRate("GMD", "Gambian Dalasi", currencyData.GMD),
        CurrencyRate("GNF", "Guinean Franc", currencyData.GNF),
        CurrencyRate("GTQ", "Guatemalan Quetzal", currencyData.GTQ),
        CurrencyRate("GYD", "Guyanese Dollar", currencyData.GYD),
        CurrencyRate("HKD", "Hong Kong Dollar", currencyData.HKD),
        CurrencyRate("HNL", "Honduran Lempira", currencyData.HNL),
        CurrencyRate("HRK", "Croatian Kuna", currencyData.HRK),
        CurrencyRate("HTG", "Haitian Gourde", currencyData.HTG),
        CurrencyRate("HUF", "Hungarian Forint", currencyData.HUF),
        CurrencyRate("IDR", "Indonesian Rupiah", currencyData.IDR),
        CurrencyRate("ILS", "Israeli New Shekel", currencyData.ILS),
        CurrencyRate("IMP", "Isle of Man Pound", currencyData.IMP),
        CurrencyRate("INR", "Indian Rupee", currencyData.INR),
        CurrencyRate("IQD", "Iraqi Dinar", currencyData.IQD),
        CurrencyRate("IRR", "Iranian Rial", currencyData.IRR),
        CurrencyRate("ISK", "Icelandic Króna", currencyData.ISK),
        CurrencyRate("JEP", "Jersey Pound", currencyData.JEP),
        CurrencyRate("JMD", "Jamaican Dollar", currencyData.JMD),
        CurrencyRate("JOD", "Jordanian Dinar", currencyData.JOD),
        CurrencyRate("JPY", "Japanese Yen", currencyData.JPY),
        CurrencyRate("KES", "Kenyan Shilling", currencyData.KES),
        CurrencyRate("KGS", "Kyrgyzstani Som", currencyData.KGS),
        CurrencyRate("KHR", "Cambodian Riel", currencyData.KHR),
        CurrencyRate("LRD", "Liberian Dollar", currencyData.LRD),
        CurrencyRate("LSL", "Lesotho Loti", currencyData.LSL),
        CurrencyRate("LTL", "Lithuanian Litas", currencyData.LTL),
        CurrencyRate("LVL", "Latvian Lats", currencyData.LVL),
        CurrencyRate("LYD", "Libyan Dinar", currencyData.LYD),
        CurrencyRate("MAD", "Moroccan Dirham", currencyData.MAD),
        CurrencyRate("MDL", "Moldovan Leu", currencyData.MDL),

        CurrencyRate("MYR", "Malaysian Ringgit", currencyData.MYR),
        CurrencyRate("MZN", "Mozambican Metical", currencyData.MZN),

        CurrencyRate("PKR", "Pakistani Rupee", currencyData.PKR),
        CurrencyRate("PLN", "Polish Zloty", currencyData.PLN),
        CurrencyRate("PYG", "Paraguayan Guarani", currencyData.PYG),
        CurrencyRate("QAR", "Qatari Rial", currencyData.QAR),
        CurrencyRate("RON", "Romanian Leu", currencyData.RON),
        CurrencyRate("RSD", "Serbian Dinar", currencyData.RSD),
        CurrencyRate("RUB", "Russian Ruble", currencyData.RUB),
        CurrencyRate("RWF", "Rwandan Franc", currencyData.RWF),

        CurrencyRate("TND", "Tunisian Dinar", currencyData.TND),
        CurrencyRate("TOP", "Tongan Paʻanga", currencyData.TOP),
        CurrencyRate("TRY", "Turkish Lira", currencyData.TRY),
        CurrencyRate("TTD", "Trinidad and Tobago Dollar", currencyData.TTD),
        CurrencyRate("TWD", "New Taiwan Dollar", currencyData.TWD),
        CurrencyRate("TZS", "Tanzanian Shilling", currencyData.TZS),
        CurrencyRate("UAH", "Ukrainian Hryvnia", currencyData.UAH),
        CurrencyRate("UGX", "Ugandan Shilling", currencyData.UGX),
        CurrencyRate("USD", "United States Dollar", currencyData.USD),

        CurrencyRate("VND", "Vietnamese Dong", currencyData.VND),


        )
}