# [STL (file format)](https://en.wikipedia.org/wiki/STL_(file_format))

__STL__ is a [file format]() native to the [stereolithography]() [CAD]() software created by [3D Systems](). STL has several [backronym]()s such as "Standard Triangle Language" and "Standard [Tessellation]() Language". This file format is supported by many other software packages; it is widely used for [rapid prototyping](), [3D printing]() and [computer-aided manufacturing](). STL files describe only the surface geometry of a three-dimensional object without any representation of color, texture or other common CAD model attributes. The STL format specifies both [ASCII]() and [binary]() representations. Binary files are more common, since they are more compact.

An STL file describes a raw, unstructured [triangulated]() surface by the [unit]() [normal]() and vertices (ordered by the [right-hand rule]()) of the triangles using a three-dimensional [Cartesian coordinate system](). In the original specification, all STL coordinates were required to be positive numbers, but this restriction is no longer enforced and negative coordinates are commonly encountered in STL files today. STL files contain no scale information, and the units are arbitrary.

## ASCII STL
An ASCII STL file begins with the line

```
solid name
```

where _name_ is an optional string (though if _name_ is omitted there must still be a space after solid). The file continues with any number of triangles, each represented as follows:

```
facet normal ni nj nk
    outer loop
        vertex v1x v1y v1z
        vertex v2x v2y v2z
        vertex v3x v3y v3z
    endloop
endfacet
```

where each _n_ or _v_ is a [floating-point number]() in sign-[mantissa]()-"e"-sign-[exponent]() format, e.g., "2.648000e-002". The file concludes with

```
endsolid name
```

The structure of the format suggests that other possibilities exist (e.g., facets with more than one "loop", or loops with more than three vertices). In practice, however, all facets are simple triangles.

White space (spaces, tabs, newlines) may be used anywhere in the file except within numbers or words. The spaces between "facet" and "normal" and between "outer" and "loop" are required.

## Binary STL
Because ASCII STL files can become very large, a binary version of STL exists. A binary STL file has an 80-character header (which is generally ignored, but should never begin with "solid" because that may lead some software to assume that this is an ASCII STL file). Following the header is a 4-byte [little-endian]() unsigned integer indicating the number of triangular facets in the file. Following that is data describing each triangle in turn. The file simply ends after the last triangle.

Each triangle is described by twelve 32-bit floating-point numbers: three for the normal and then three for the X/Y/Z coordinate of each vertex – just as with the ASCII version of STL. After these follows a 2-byte ("short") unsigned integer that is the "attribute byte count" – in the standard format, this should be zero because most software does not understand anything else.

Floating-point numbers are represented as [IEEE floating-point]() numbers and are assumed to be [little-endian](), although this is not stated in documentation.

```
UINT8[80] – Header
UINT32 – Number of triangles

foreach triangle
    REAL32[3] – Normal vector
    REAL32[3] – Vertex 1
    REAL32[3] – Vertex 2
    REAL32[3] – Vertex 3
    UINT16    – Attribute byte count (n)
    UINT8[n]  - Extra attribute data
end
```

## Color in binary STL

There are at least two non-standard variations on the binary STL format for adding color information:

- The VisCAM and SolidView software packages use the two "attribute byte count" bytes at the end of every triangle to store a 15-bit [RGB]() color:
    - bits 0 to 4 are the intensity level for blue (0 to 31),
    - bits 5 to 9 are the intensity level for green (0 to 31),
    - bits 10 to 14 are the intensity level for red (0 to 31),
    - bit 15 is 1 if the color is valid, or 0 if the color is not valid (as with normal STL files).
- The Materialise Magics software uses the 80-byte header at the top of the file to represent the overall color of the entire part. If color is used, then somewhere in the header should be the [ASCII]() string "COLOR=" followed by four bytes representing red, green, blue and [alpha channel]() (transparency) in the range 0–255. This is the color of the entire object, unless overridden at each facet. Magics also recognizes a material description; a more detailed surface characteristic. Just after "COLOR=RGBA" specification should be another ASCII string ",MATERIAL=" followed by three colors (3×4 bytes): first is a color of [diffuse reflection](), second is a color of [specular highlight](), and third is an [ambient light](). Material settings are preferred over color. The per-facet color is represented in the two "attribute byte count" bytes as follows:
    - bits 0 to 4 are the intensity level for red (0 to 31),
    - bits 5 to 9 are the intensity level for green (0 to 31),
    - bits 10 to 14 are the intensity level for blue (0 to 31),
    - bit 15 is 0 if this facet has its own unique color, or 1 if the per-object color is to be used.

The red/green/blue ordering within those two bytes is reversed in these two approaches – so while these formats could easily have been compatible, the reversal of the order of the colors means that they are not – and worse still, a generic STL file reader cannot automatically distinguish between them. There is also no way to have facets be selectively transparent because there is no per-facet alpha value – although in the context of current rapid prototyping machinery, this is not important.

## The facet normal
In both ASCII and binary versions of STL, the [facet normal]() should be a [unit vector]() pointing outwards from the solid object. In most software this may be set to (0,0,0), and the software will automatically calculate a normal based on the order of the triangle vertices using the "[right-hand rule]()". Some STL loaders (e.g. the STL plugin for Art of Illusion) check that the normal in the file agrees with the normal they calculate using the right-hand rule and warn the user when it does not. Other software may ignore the facet normal entirely and use only the right-hand rule. Although it is rare to specify a normal that cannot be calculated using the right-hand rule, in order to be entirely portable, a file should both provide the facet normal and order the vertices appropriately.
A notable exception is [SolidWorks](), which uses the normal for [shading effect]()s.

## Use in 3D printing

[3D printers]() build objects by solidifying one layer at a time. This requires a series of closed 2D contours that are filled in with solidified material as the layers are fused together. A natural file format for such a machine would be a series of closed polygons corresponding to different Z-values. However, since it is possible to vary the layer thicknesses for a faster though less precise build, it was easier to define the model to be built as a closed [polyhedron]() that can be sliced at the necessary horizontal levels.

The STL file format appears capable of defining a polyhedron with any polygonal facet, but in practice it is only ever used for triangles, which means that much of the syntax of the ASCII protocol is superfluous.

To properly form a 3D volume, the surface represented by any STL files must be closed and connected, where every edge is part of exactly two triangles, and not self-intersecting. Since the STL syntax does not enforce this property, it can be ignored for applications where the closedness does not matter. The closedness only matters insofar as the software that slices the triangles requires it to ensure that the resulting 2D polygons are closed. Sometimes such software can be written to clean up small discrepancies by moving vertices that are close together so that they coincide. The results are not predictable, but it is often sufficient.

## Use in other fields
STL file format is simple and easy to output. Consequently, many [computer-aided design]() systems can output the STL file format. Although the output is simple to produce, mesh connectivity information is discarded because the identity of shared vertices is lost.

Many [computer-aided manufacturing]() systems require triangulated models. STL format is not the most memory- and computationally efficient method for transferring this data, but STL is often used to import the triangulated geometry into the [CAM]() system. The format is commonly available, so the CAM system will use it. In order to use the data, the CAM system may have to reconstruct the connectivity. As STL files do not save the physical dimension of a unit, a CAM system will ask for it. Typical units are mm and inch.

STL can also be used for interchanging data between CAD/CAM systems and computational environments such as [Mathematica]().

## Representation of curved surfaces

It is not possible to use triangles to perfectly represent curved surfaces. To compensate, users often save enormous STL files to reduce the inaccuracy. Native formats of 3D design software files use [mathematical surfaces]() to preserve detail losslessly in small files.
