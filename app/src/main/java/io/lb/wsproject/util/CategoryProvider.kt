package io.lb.wsproject.util

import io.lb.wsproject.R
import io.lb.wsproject.feature_main.domain.model.Category

object CategoryProvider {
    val categories = listOf(
        Category(
            text = "Casa",
            painterId = R.drawable.ic_home
        ),
        Category(
            text = "Negócios",
            painterId = R.drawable.ic_business
        ),
        Category(
            text = "Estudos",
            painterId = R.drawable.ic_school
        ),
        Category(
            text = "Hobbies",
            painterId = R.drawable.ic_esports
        ),
        Category(
            text = "Compras",
            painterId = R.drawable.ic_shopping
        ),
        Category(
            text = "Viagem",
            painterId = R.drawable.ic_travel
        )
    )
}