/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelformen.domain;

/**
 *
 * @author bruger
 */
public enum RoomType
{
    SINGLE(1, 20, false),
    DOUBLE(2, 40, false),
    QUEEN(1, 40, false),
    KING (2, 50, false),
    SHEIK(3, 100, false),
    FOR_MEN(5, 250, true);
    
    private final int _beds;
    private final int _size;
    private final boolean _freeServices;
    
    public int getBeds() { return _beds; }
    public int getSize() { return _size; }
    public boolean getFreeServices() { return _freeServices; }
    
    
    RoomType(int beds, int size, boolean freeServices)
    {
        _beds = beds;
        _size = size;
        _freeServices = freeServices;
    }
}
