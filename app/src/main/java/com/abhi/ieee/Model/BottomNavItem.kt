package com.abhi.ieee.Model

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val title :String,
    val selectedIcon : ImageVector,
    val unSelectedIcon : ImageVector,
    val hasNews : Boolean = false,
    val badgeCount : Int  ?= null

)
