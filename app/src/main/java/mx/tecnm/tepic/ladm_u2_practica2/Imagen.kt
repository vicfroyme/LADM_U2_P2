package mx.tecnm.tepic.ladm_u2_practica2

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint

class Imagen (l:Lienzo, ima:Int, posX:Float, posY:Float){
    var x = posX
    var y = posY
    var imagen =BitmapFactory.decodeResource(l.resources,ima)

    fun pintar (c: Canvas){
        c.drawBitmap(imagen,x,y, Paint())
    }

    fun area (toqueX:Float, toqueY: Float) : Boolean{
        var x2 = x+imagen.width
        var y2 = y+imagen.height

        if(toqueX >= x && toqueX <= x2){
            if (toqueY >= x && toqueY <= x2){
                return true
            }
        }
        return false
    }

    fun mover(toqueX:Float, toqueY: Float){
        x = toqueX - imagen.width/2
        y = toqueY - imagen.height/2
    }

    fun colision (obj : Imagen) : Boolean{
        var x2 = x+imagen.width
        var y2 = y+imagen.height

        if (obj.area(x,y)){
            return true
        }
        if (obj.area(x2,y)){
            return true
        }
        if (obj.area(x,y2)){
            return true
        }
        if (obj.area(x2,y2)){
            return true
        }
        return false
    }

}