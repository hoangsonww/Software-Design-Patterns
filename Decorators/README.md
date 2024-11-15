# `Decorators` Directory - Applying the Decorator Pattern to Digital Image Processing

The `Decorators` directory explores the **Decorator Design Pattern** by applying it to digital image manipulation. This project introduces how decorators can be used to incrementally add visual layers and effects to images, allowing for dynamic, modular, and extensible image processing workflows. Within this directory, each decorator class wraps an existing `Image` object, enhancing or modifying it in a specific way. The resulting layered approach models the image processing techniques seen in platforms like Snapchat and Instagram, where filters and effects are added to images in sequence.

This directory includes both **base image classes** and **decorator classes**, all of which implement the `Image` interface:
1. **Base Image Classes**: `SolidColorImage` and `PictureImage` provide a foundation for applying decorators.
2. **Decorator Classes**: `SquareDecorator`, `CircleDecorator`, `BorderDecorator`, and `ZoomDecorator` allow for various effects and modifications to be applied incrementally to an image.

Each decorator class builds upon the previous ones, allowing multiple layers of effects to be added. The code exemplifies how the decorator pattern can create flexible and extensible image modifications.

## Key Components and Decorator Structure

### Base Image Classes

Two base classes, `SolidColorImage` and `PictureImage`, form the starting point for decorating. These classes implement the `Image` interface directly, representing static images without any decorations.

- **`SolidColorImage`**: Represents a simple solid color background image. This class sets up an image with a single color across all pixels. Its main purpose is to serve as a uniform background for additional decorative layers.
  - **Key Methods**: `getPixelColor()` (returns the solid color for all pixels), `getWidth()`, `getHeight()`, and `numLayers()` (returns 1).
  - **Purpose**: Provides a blank canvas that can be decorated with other effects.

- **`PictureImage`**: Represents an image loaded from a file, using a `BufferedImage` to store pixel data from a given image file path.
  - **Key Methods**: `getPixelColor()` (returns the color of each pixel based on its position), `getWidth()`, `getHeight()`, and `numLayers()` (returns 1).
  - **Purpose**: Acts as a foundation for decoration, allowing users to apply visual modifications to a pre-existing image.

These classes provide a starting point for applying decorators, which add new layers and transformations to these base images.

### Decorator Classes and the Decorator Pattern in Action

Each decorator class in this directory encapsulates an `Image` object, modifying its appearance by adding an effect over the underlying image. These decorators stack on top of each other, making it possible to apply multiple transformations in sequence.

#### `SquareDecorator`

The **SquareDecorator** overlays a colored square on top of the existing image. The size, color, and position of the square are configurable, and the square's color supersedes the underlying image color within its bounds.

- **Key Features**:
  - **Encapsulation of Base Image**: This decorator encapsulates an `Image` object, which it decorates by overriding certain pixels with a square shape.
  - **Selective Pixel Override**: The `getPixelColor()` method first checks if the pixel is within the square bounds. If it is, the square’s color is returned; if not, the original pixel color from the base image is returned.
  - **Layer Count**: `numLayers()` increases by 1 to account for the square as an additional layer.
- **Purpose**: Allows the addition of a square overlay, showing how the decorator pattern can alter specific regions of an image.

#### `CircleDecorator`

The **CircleDecorator** adds a circular overlay to the image, applying a specified color within the bounds of a circle. The circle’s position, radius, and color are customizable.

- **Key Features**:
  - **Circular Pixel Check**: In `getPixelColor()`, a pixel is determined to be inside the circle if it is within a certain distance from the circle’s center, based on the radius. This decorator uses the distance formula to make this determination.
  - **Layer Count**: `numLayers()` reflects the additional circle layer, incrementing by 1.
- **Purpose**: Demonstrates flexibility in shape decoration, allowing users to add circular overlays to any image while still preserving other aspects of the image beneath the circle.

#### `BorderDecorator`

The **BorderDecorator** surrounds the base image with a solid border of a specified color and thickness. Unlike other decorators, this one adjusts the image’s dimensions to include the border.

- **Key Features**:
  - **Adjusted Dimensions**: This decorator expands the width and height of the image to account for the thickness of the border, applying the specified color to the border area.
  - **Modified `getPixelColor()`**: If the pixel falls within the border area, the border color is returned; otherwise, the color from the encapsulated image is shown.
  - **Layer Count**: `numLayers()` reflects the border as an additional layer.
- **Purpose**: Expands the decorator pattern by modifying not only appearance but also the image's dimensions, showcasing how decorators can add visual and spatial effects.

#### `ZoomDecorator`

The **ZoomDecorator** scales the underlying image by a specified multiplier, making it appear larger. This decorator provides two constructors: one with a default multiplier of 2, and another allowing a custom multiplier.

- **Key Features**:
  - **Scaled Pixel Mapping**: The `getPixelColor()` method adjusts the pixel coordinates to map each original pixel to a scaled region in the enlarged image, creating a zoomed effect.
  - **Dynamic Sizing**: The width and height of the image are multiplied by the zoom factor.
  - **Layer Count**: Adds one layer for the zoom effect.
- **Purpose**: Demonstrates spatial scaling, illustrating how decorators can manipulate image dimensions to create a zoomed-in appearance.

### Layered Composition and Flexibility with Decorators

Each decorator class adds an additional visual layer over the image, and the `numLayers()` method tracks this accumulation of effects, reflecting how many modifications have been applied. The sequential application of decorators provides a flexible system where complex visual effects can be created by chaining simple, modular decorations.

### Putting it All Together in `Main.java`

The `Main.java` file’s `makeImage()` method provides a complete example of layering decorators in sequence to build a final image with multiple effects:
1. **Base Image**: Loads `img/headshot.jpg` as the base image.
2. **Red Border**: Applies a thin red border around the image.
3. **Blue Border**: Adds a thicker blue border, layering it outside the red one.
4. **Yellow Circle**: Overlays a yellow circle in the specified position.
5. **Orange Square**: Adds an orange square in another region of the image.
6. **Zoom**: Applies a zoom effect, doubling the image size.

The final composition showcases the decorator pattern’s power in building layered, customizable images where each decorator can be independently added, removed, or adjusted. This layering allows users to create complex visual transformations without altering the underlying image structure or code.

## Summary of the `Decorators` Directory

The `Decorators` directory illustrates how the **Decorator Design Pattern** can be used to incrementally modify and enhance digital images. By wrapping `Image` objects with successive decorator classes, the code creates a modular system where new visual effects can be stacked, customized, and extended. Each decorator class serves a specific purpose, from adding shapes and borders to scaling the image, making it easy to build and modify image processing workflows.

This approach exemplifies how the decorator pattern provides flexibility, modularity, and reusability, allowing for diverse visual compositions without modifying the core image class or creating complex inheritance hierarchies. This directory is a comprehensive example of how decorators can transform and enhance images, applicable to a wide range of graphic and UI design contexts.
