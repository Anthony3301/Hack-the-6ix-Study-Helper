import math
import datetime
import json
import arcade


SCREEN_WIDTH = 1000
SCREEN_HEIGHT = 600
SCREEN_TITLE = "Study Helper"

class MainScreen(arcade.Window):
    """Main application container
    """

    def __init__(self) -> None:

        super().__init__(SCREEN_WIDTH, SCREEN_HEIGHT, SCREEN_TITLE)
        arcade.set_background_color(arcade.color.BLACK)

    
    def setup(self):
        pass

    def on_draw(self):
        arcade.start_render()

def main():
    window = MainScreen()
    window.setup()
    arcade.run()

if __name__ == "__main__":
    main()
    




        
