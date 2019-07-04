package com.company.client;

import com.company.numberconversion.NumberConversionStub;
import org.apache.axis2.AxisFault;
import org.apache.axis2.databinding.types.UnsignedLong;

import java.rmi.RemoteException;

public class NumberConversionClient {

    static public String numberConversion(int a) throws RemoteException {

        NumberConversionStub numberConversionStub = new NumberConversionStub();

        NumberConversionStub.NumberToWords numberToWords = new NumberConversionStub.NumberToWords();

        UnsignedLong unsignedLong = new UnsignedLong(a);

        numberToWords.setUbiNum(unsignedLong);
        NumberConversionStub.NumberToWordsResponse numberToWordsResponse = numberConversionStub.numberToWords(numberToWords);

        return numberToWordsResponse.getNumberToWordsResult();
    }
}
