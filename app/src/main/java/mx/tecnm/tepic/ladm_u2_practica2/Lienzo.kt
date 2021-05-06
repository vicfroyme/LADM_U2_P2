package mx.tecnm.tepic.ladm_u2_practica2

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class Lienzo (act : MainActivity) : View(act) {
    var con = 0
    var estadotop = false
    var estado = true
    var pantalla = 0
    var play = Imagen(this, R.drawable.play, 140f, 350f)
    var fondo = Imagen(this, R.drawable.fondo, 0f, 0f)
    var topo1 = Imagen(this, R.drawable.topo1, 140f, 180f)
    var topo2 = Imagen(this, R.drawable.topo1, 500f, 180f)
    var topo3 = Imagen(this, R.drawable.topo1, 300f, 480f)
    var topo4 = Imagen(this, R.drawable.topo1, 140f, 800f)
    var topo5 = Imagen(this, R.drawable.topo1, 500f, 800f)


    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val p = Paint()

        invalidate()

        when (pantalla){
            0 -> {
                fondo.pintar(c)
                play.pintar(c)

                invalidate()
            }
            1 -> {
                var hilo = HiloC(this)
                if (estado) {
                    hilo.start()
                }

                if (con in 0..100 || con in 600..700) {
                    topo1.pintar(c)
                }
                if (con in 80..180 || con in 400..500) {
                    topo2.pintar(c)
                }
                if (con in 160..260 || con in 300..400) {
                    topo3.pintar(c)
                }
                if (con in 240..340 || con in 120..220) {
                    topo4.pintar(c)
                }
                if (con in 320..420 || con in 50..150) {
                    topo5.pintar(c)
                }

                if (estadotop == true && con == 11 && con == 70) {
                    topo1.imagen = BitmapFactory.decodeResource(resources, R.drawable.topo1)
                    estadotop = false
                }
                if (estadotop == true && con == 19 && con == 51) {
                    topo2.imagen = BitmapFactory.decodeResource(resources, R.drawable.topo1)
                    estadotop = false
                }
                if (estadotop == true && con == 27 && con == 41) {
                    topo3.imagen = BitmapFactory.decodeResource(resources, R.drawable.topo1)
                    estadotop = false
                }
                if (estadotop == true && con == 35 && con == 23) {
                    topo4.imagen = BitmapFactory.decodeResource(resources, R.drawable.topo1)
                    estadotop = false
                }
                if (estadotop == true && con == 43 && con == 16) {
                    topo5.imagen = BitmapFactory.decodeResource(resources, R.drawable.topo1)
                    estadotop = false
                }
                invalidate()
            }
            }
        }



    override fun onTouchEvent(e: MotionEvent): Boolean {
        when (e.action) {
            MotionEvent.ACTION_DOWN -> {
                if (topo1.area(e.x, e.y)) {
                    topo1.imagen = BitmapFactory.decodeResource(resources, R.drawable.topo2)
                    estadotop = true
                }
                if (topo2.area(e.x, e.y)) {
                    topo2.imagen = BitmapFactory.decodeResource(resources, R.drawable.topo2)
                    estadotop = true
                }
                if (topo3.area(e.x, e.y)) {
                    topo3.imagen = BitmapFactory.decodeResource(resources, R.drawable.topo2)
                    estadotop = true
                }
                if (topo4.area(e.x, e.y)) {
                    topo4.imagen = BitmapFactory.decodeResource(resources, R.drawable.topo2)
                    estadotop = true
                }
                if (topo5.area(e.x, e.y)) {
                    topo5.imagen = BitmapFactory.decodeResource(resources, R.drawable.topo2)
                    estadotop = true
                }
            }
        }
        super.onTouchEvent(e)
        if(play.area(e.x, e.y) && pantalla == 0){
            pantalla = 1
        }
        invalidate()
        return true
    }
}

class HiloC (et: Lienzo) :Thread() {
    var etiGlobal = et

    override fun run() {
        super.run()
        while (true){
            if (etiGlobal.con == 1000){
                etiGlobal.con = 0
            }
            etiGlobal.con++
            sleep(1000000)
        }
    }
}
