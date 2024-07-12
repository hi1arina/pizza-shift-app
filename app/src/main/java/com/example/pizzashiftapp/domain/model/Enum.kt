package com.example.pizzashiftapp.domain.model

enum class PizzaDoughsType {
    THIN,
    THICK;
}

enum class PizzaIngredientType {
    PINEAPPLE,
    MOZZARELLA,
    PEPPERONI,
    PEPERONI,
    GREEN_PEPPER,
    MUSHROOMS,
    BASIL,
    CHEDDAR,
    PARMESAN,
    FETA,
    HAM,
    PICKLE,
    TOMATO,
    BACON,
    ONION,
    CHILE,
    SHRIMPS,
    CHICKEN_FILLET,
    MEATBALLS;
}

val ingredientTranslationMap = mapOf(
    PizzaIngredientType.PINEAPPLE to "Сочные ананасы",
    PizzaIngredientType.MOZZARELLA to "Сливочная моцарелла",
    PizzaIngredientType.PEPPERONI to "Пикантная пепперони",
    PizzaIngredientType.PEPERONI to "Пикантная пепперони",
    PizzaIngredientType.GREEN_PEPPER to "Сладкий перец",
    PizzaIngredientType.MUSHROOMS to "Шампиньоны",
    PizzaIngredientType.BASIL to "Итальянские травы",
    PizzaIngredientType.CHEDDAR to "Чеддер",
    PizzaIngredientType.PARMESAN to "Пармезан",
    PizzaIngredientType.FETA to "Фета",
    PizzaIngredientType.HAM to "Ветчина",
    PizzaIngredientType.PICKLE to "Маринованные огурчики",
    PizzaIngredientType.TOMATO to "Свежие томаты",
    PizzaIngredientType.BACON to "Бекон",
    PizzaIngredientType.ONION to "Красный лук",
    PizzaIngredientType.CHILE to "Перец чили",
    PizzaIngredientType.SHRIMPS to "Креветки",
    PizzaIngredientType.CHICKEN_FILLET to "Нежный цыпленок",
    PizzaIngredientType.MEATBALLS to "Мясные шарики"
)

enum class PizzaSizeType {
    SMALL,
    MEDIUM,
    LARGE;
}
