package org.celllife.idart.common;

import static org.celllife.idart.common.UnitOfMeasureCode.unitOfMeasureCode;
import static org.celllife.idart.common.UnitOfMeasureTypes.*;

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-18
 * Time: 12h24
 */
public enum UnitsOfMeasure {

    each(unitOfMeasureCode("each"), "Each", ARBITRARY.code),

    ps(unitOfMeasureCode("ps"), "PicoSecond", TIME.code),
    ns(unitOfMeasureCode("ns"), "NanoSecond", TIME.code),
    us(unitOfMeasureCode("us"), "MicroSecond", TIME.code),
    ms(unitOfMeasureCode("ms"), "MilliSecond", TIME.code),
    sec(unitOfMeasureCode("sec"), "Second", TIME.code),
    ks(unitOfMeasureCode("ks"), "KiloSecond", TIME.code),
    Ms(unitOfMeasureCode("Ms"), "Megasecond", TIME.code),
    min(unitOfMeasureCode("min"), "Minute", TIME.code),
    h(unitOfMeasureCode("h"), "Hour", TIME.code),
    d(unitOfMeasureCode("d"), "Day", TIME.code),
    wk(unitOfMeasureCode("wk"), "Week", TIME.code),
    Mo(unitOfMeasureCode("Mo"), "Month", TIME.code),
    yr(unitOfMeasureCode("yr"), "Year", TIME.code),

    fg(unitOfMeasureCode("fg"), "FemtoGram", SI_MASS.code),
    pg(unitOfMeasureCode("pg"), "PicoGram", SI_MASS.code),
    ng(unitOfMeasureCode("ng"), "NanoGram", SI_MASS.code),
    ug(unitOfMeasureCode("ug"), "MicroGram", SI_MASS.code),
    ug_TotalVolume(unitOfMeasureCode("ug_TotalVolume"), "MicroGramsPerTotalVolume", SI_MASS.code),
    ug_Spec(unitOfMeasureCode("ug_Spec"), "MicroGramsPerSpecimen", SI_MASS.code),
    mg(unitOfMeasureCode("mg"), "MilliGram", SI_MASS.code),
    mg_Volume(unitOfMeasureCode("mg_Volume"), "MilliGramsPerVolume", SI_MASS.code),
    mg_TotalVolume(unitOfMeasureCode("mg_TotalVolume"), "MilliGramPerTotalVolume", SI_MASS.code),
    g(unitOfMeasureCode("g"), "Gram", SI_MASS.code),
    g_TotalWeight(unitOfMeasureCode("g_TotalWeight"), "GramsPerTotalWeight", SI_MASS.code),
    dg(unitOfMeasureCode("dg"), "DeciGram", SI_MASS.code),
    cg(unitOfMeasureCode("cg"), "CentiGram", SI_MASS.code),
    kg(unitOfMeasureCode("kg"), "KiloGram", SI_MASS.code),
    MetricTon(unitOfMeasureCode("MetricTon"), "MetricTon", SI_MASS.code),

    fm(unitOfMeasureCode("fm"), "FemtoMeter", SI_LENGTH.code),
    pm(unitOfMeasureCode("pm"), "PicoMeter ", SI_LENGTH.code),
    nm(unitOfMeasureCode("nm"), "NanoMeter ", SI_LENGTH.code),
    um(unitOfMeasureCode("um"), "MicroMeter", SI_LENGTH.code),
    mm(unitOfMeasureCode("mm"), "MilliMeter", SI_LENGTH.code),
    cm(unitOfMeasureCode("cm"), "CentiMeter", SI_LENGTH.code),
    dm(unitOfMeasureCode("dm"), "DeciMeter ", SI_LENGTH.code),
    m(unitOfMeasureCode("m"), "Meter     ", SI_LENGTH.code),
    km(unitOfMeasureCode("km"), "KiloMeter ", SI_LENGTH.code),

    fL(unitOfMeasureCode("fL"), "FemtoLiter", SI_VOLUME.code),
    pL(unitOfMeasureCode("pL"), "PicoLiter", SI_VOLUME.code),
    nL(unitOfMeasureCode("nL"), "NanoLiter", SI_VOLUME.code),
    uL(unitOfMeasureCode("uL"), "MicroLiter", SI_VOLUME.code),
    mL(unitOfMeasureCode("mL"), "MilliLiter", SI_VOLUME.code),
    mL_PerHeartBeat(unitOfMeasureCode("mL_PerHeartBeat"), "MilliLitersPerHeartbeat", SI_VOLUME.code),
    L(unitOfMeasureCode("L"), "Liter", SI_VOLUME.code),
    dL(unitOfMeasureCode("dL"), "DeciLiter", SI_VOLUME.code),
    cL(unitOfMeasureCode("cL"), "CentiLiter", SI_VOLUME.code),
    kL(unitOfMeasureCode("kL"), "KiloLiter", SI_VOLUME.code),
    hL(unitOfMeasureCode("hL"), "HectoLiter", SI_VOLUME.code);

    public final UnitOfMeasureCode code;

    public final String description;

    public final UnitOfMeasureTypeCode unitOfMeasureType;

    private UnitsOfMeasure(UnitOfMeasureCode code, String description, UnitOfMeasureTypeCode unitOfMeasureType) {
        this.code = code;
        this.description = description;
        this.unitOfMeasureType = unitOfMeasureType;
    }
}