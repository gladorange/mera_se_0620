package src.lesson5;

class Parameters {
    enum parameters {
        SCENE_LENGHT_X(100),
        SCENE_LENGHT_Y(100),
        ELEMENT_MAX_HIEGHT_X(5),
        ELEMENT_MAX_WIDTH_Y(5);

        private int value;

        parameters(int value) {
            this.value = value;

        }

        public int getValue() {
            return this.value;
        }
    }

    enum rectangles{
        BUTTON,
        CHECK_BOX,
        TEXT_FIELD
    }
}



