create table dishes_meals
(
    dish_id bigint not null constraint dishes_id references dishes,
    meal_id bigint not null constraint meals_id references meals
);