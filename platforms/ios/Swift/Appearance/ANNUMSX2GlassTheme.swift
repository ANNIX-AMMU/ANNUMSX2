import SwiftUI

enum ANNUMSX2GlassMode: String, CaseIterable, Codable {
    case standard
    case oledGlass
    case classicGlass
}

struct ANNUMSX2GlassSpec {
    let material: Material?
    let base: Color
    let opacity: Double
    let highlightOpacity: Double

    static func forMode(_ mode: ANNUMSX2GlassMode, reduceTransparency: Bool) -> Self {
        switch mode {
        case .standard:
            return .init(material: nil, base: .clear, opacity: 1, highlightOpacity: 0)
        case .oledGlass:
            return .init(material: reduceTransparency ? nil : .ultraThinMaterial,
                         base: .black, opacity: reduceTransparency ? 0.94 : 0.72,
                         highlightOpacity: 0.14)
        case .classicGlass:
            return .init(material: reduceTransparency ? nil : .thinMaterial,
                         base: Color(red: 0.125, green: 0.141, blue: 0.169),
                         opacity: reduceTransparency ? 0.94 : 0.78,
                         highlightOpacity: 0.20)
        }
    }
}
