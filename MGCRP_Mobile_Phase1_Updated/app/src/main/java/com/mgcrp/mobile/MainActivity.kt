package com.mgcrp.mobile

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView

class MainActivity : Activity() {
    private val bg = Color.rgb(5, 9, 19)
    private val panel = Color.rgb(12, 22, 38)
    private val cyan = Color.rgb(53, 220, 255)
    private val purple = Color.rgb(172, 102, 255)
    private val muted = Color.rgb(150, 174, 194)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = bg
        window.navigationBarColor = bg
        val scroll = ScrollView(this).apply { setBackgroundColor(bg) }
        val page = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL; setPadding(dp(22), dp(26), dp(22), dp(28)) }
        scroll.addView(page)
        page.addView(label("MONTREAL GLOBAL CITY ROLEPLAY", 11, cyan, true)); page.addView(space(10))
        page.addView(label("MGCRP", 42, Color.WHITE, true)); page.addView(label("MOBILE", 24, cyan, true)); page.addView(space(8))
        page.addView(label("YOUR CITY. YOUR IDENTITY. YOUR ROLEPLAY.", 10, muted, true)); page.addView(space(22))
        val hero = card()
        hero.addView(label("CYBER EDITION  /  MOBILE CLIENT", 10, purple, true)); hero.addView(space(12))
        hero.addView(label("WELCOME TO MONTREAL.", 22, Color.WHITE, true)); hero.addView(space(8))
        hero.addView(label("A dedicated mobile gateway to Montreal Global City RolePlay.", 14, muted, false)); hero.addView(space(18))
        hero.addView(label("SERVER PROFILE", 10, cyan, true)); hero.addView(space(6))
        hero.addView(label("MGCRP  •  open.mp compatible server", 14, Color.WHITE, true))
        hero.addView(label("31.58.143.97:7777", 12, muted, false)); page.addView(hero)
        page.addView(space(18)); page.addView(actionButton("ENTER CITY", cyan) { showMessage(page, "Game client integration is the next milestone. This prototype does not connect yet.") })
        page.addView(space(10)); page.addView(actionButton("SERVER NEWS", purple) { showMessage(page, "News feed placeholder — MGCRP announcements API is not configured yet.") })
        page.addView(space(10)); page.addView(actionButton("CLIENT SETTINGS", panel) { showMessage(page, "Graphics, controls and resource settings will be added later.") })
        page.addView(space(22)); page.addView(label("SYSTEM STATUS", 11, cyan, true)); page.addView(space(8))
        val status = card(); status.addView(label("LAUNCHER PROTOTYPE  •  v0.1.0", 12, Color.WHITE, true)); status.addView(space(5))
        status.addView(label("Game client: NOT INTEGRATED", 12, muted, false)); status.addView(label("Server API: NOT CONFIGURED", 12, muted, false))
        status.addView(label("ARMv7 + ARM64: BUILD TARGET PLANNED", 12, muted, false)); page.addView(status)
        page.addView(space(22)); page.addView(label("MONTREAL GLOBAL CITY ROLEPLAY", 10, muted, true).apply { gravity = Gravity.CENTER })
        page.addView(label("BUILT DIFFERENT. PLAY DIFFERENT.", 10, purple, true).apply { gravity = Gravity.CENTER })
        setContentView(scroll)
    }
    private fun card() = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL; setPadding(dp(16), dp(16), dp(16), dp(16)); setBackgroundColor(panel) }
    private fun label(t: String, s: Int, c: Int, b: Boolean) = TextView(this).apply { text=t; textSize=s.toFloat(); setTextColor(c); typeface=if(b) Typeface.DEFAULT_BOLD else Typeface.DEFAULT; letterSpacing=if(b) 0.04f else 0.01f }
    private fun actionButton(t: String, c: Int, click: () -> Unit) = Button(this).apply { text=t; isAllCaps=false; setTextColor(Color.WHITE); setBackgroundColor(c); setOnClickListener { click() } }
    private fun showMessage(parent: LinearLayout, message: String) { parent.addView(label(message, 12, cyan, false).apply { setPadding(dp(8), dp(10), dp(8), dp(10)) }) }
    private fun space(h: Int) = View(this).apply { layoutParams=LinearLayout.LayoutParams(1, dp(h)) }
    private fun dp(v: Int) = (v * resources.displayMetrics.density).toInt()
}
