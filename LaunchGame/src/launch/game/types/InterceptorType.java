/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package launch.game.types;

import java.nio.ByteBuffer;

/**
 *
 * @author tobster
 */
public class InterceptorType extends LaunchType
{
    private static final int DATA_SIZE = 10;
    
    private byte cSpeedIndex;
    private byte cRangeIndex;
    private int cInterceptorCost;
    private float cInterceptorHitChance;
    
    public InterceptorType(byte cID, boolean bPurchasable, String strName, int lAssetID, int cInterceptorCost, float cInterceptorHitChance, byte cSpeedIndex, byte cRangeIndex)
    {
        super(cID, bPurchasable, strName, lAssetID);
        this.cInterceptorCost = cInterceptorCost;
        this.cInterceptorHitChance = cInterceptorHitChance;
        this.cSpeedIndex = cSpeedIndex;
        this.cRangeIndex = cRangeIndex;
    }
    
    public InterceptorType(ByteBuffer bb)
    {
        super(bb);
        cInterceptorCost = bb.getInt();
        cInterceptorHitChance = bb.getFloat();
        cSpeedIndex = bb.get();
        cRangeIndex = bb.get();
    }

    @Override
    public byte[] GetData()
    {
        byte[] cBaseData = super.GetData();
        
        ByteBuffer bb = ByteBuffer.allocate(DATA_SIZE + cBaseData.length);
        
        bb.put(cBaseData);
        bb.putInt(cInterceptorCost);
        bb.putFloat(cInterceptorHitChance);
        bb.put(cSpeedIndex);
        bb.put(cRangeIndex);
        
        return bb.array();
    }
    
    public byte GetSpeedIndex() { return cSpeedIndex; }
    
    public byte GetRangeIndex() { return cRangeIndex; }
    
    public int GetInterceptorCost() { return cInterceptorCost; }
    
    public float GetHitChance() { return cInterceptorHitChance; }

    @Override
    public int GetFeatureMagnitude()
    {
        return 1 + cSpeedIndex + cRangeIndex;
    }
}
