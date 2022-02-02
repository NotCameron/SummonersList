PRAGMA foreign_keys=ON;
BEGIN TRANSACTION;
CREATE TABLE champions (
         CID INTEGER, 
         Name TEXT NOT NULL, 
         DamageType TEXT NOT NULL, 
         SkinNumber INTEGER NOT NULL, 
         ReleaseDate TEXT NOT NULL, 
         BEPrice INTEGER NOT NULL, 
         RPPrice INTEGER NOT NULL,
		 PRIMARY KEY(CID)
 );
INSERT INTO champions VALUES(1, 'Aatrox', 'AD', 18, '2013-06-13', 4800, 880);
INSERT INTO champions VALUES(2, 'Ahri', 'AP', 14, '2011-12-14', 3150, 790);
INSERT INTO champions VALUES(3, 'Akali', 'AD', 14, '2010-05-11', 3150, 790);
INSERT INTO champions VALUES(4, 'Alistar', 'AP', 15, '2009-02-21', 1350, 585);
INSERT INTO champions VALUES(5, 'Amumu', 'AP', 12, '2009-06-26', 450, 260);
INSERT INTO champions VALUES(6, 'Anivia', 'AP', 10, '2009-07-10', 3150, 790);
INSERT INTO champions VALUES(7, 'Annie', 'AP', 14, '2009-02-21', 450, 260);
INSERT INTO champions VALUES(8, 'Aphelios', 'AD', 3, '2019-12-11', 6300, 975);
INSERT INTO champions VALUES(9, 'Ashe', 'AD', 13, '2009-02-21', 450, 260);
INSERT INTO champions VALUES(10, 'Aurelion Sol', 'AP', 4, '2016-03-24', 6300, 975);
INSERT INTO champions VALUES(11, 'Azir', 'AP', 6, '2014-09-16', 4800, 880);
INSERT INTO champions VALUES(12, 'Bard', 'AP', 5, '2015-03-12', 6300, 975);
INSERT INTO champions VALUES(13, 'Blitzcrank', 'AP', 13, '2009-09-02', 3150, 790);
INSERT INTO champions VALUES(14, 'Brand', 'AP', 9, '2011-04-12', 4800, 880);
INSERT INTO champions VALUES(15, 'Braum', 'AP', 7, '2014-05-12', 4800, 880);
INSERT INTO champions VALUES(16, 'Caitlyn', 'AD', 11, '2011-01-04', 4800, 880);
INSERT INTO champions VALUES(17, 'Camille', 'AD', 4, '2016-12-07', 6300, 975);
INSERT INTO champions VALUES(18, 'Cassiopeia', 'AP', 7, '2010-12-14', 4800, 880);
INSERT INTO champions VALUES(19, 'Cho Gath', 'AP', 8, '2009-06-26', 1350, 585);
INSERT INTO champions VALUES(20, 'Corki', 'AD', 10, '2009-09-19', 3150, 790);

CREATE TABLE role ( 
         CID INTEGER NOT NULL, 
         RID INTEGER NOT NULL, 
         Class TEXT NOT NULL,
		 PRIMARY KEY(RID),
         FOREIGN KEY(CID) REFERENCES champions(CID) ON DELETE CASCADE
 );
INSERT INTO role VALUES(1, 1, 'Juggernaut');
INSERT INTO role VALUES(2, 2, 'Burst');
INSERT INTO role VALUES(3, 3, 'Assassin');
INSERT INTO role VALUES(4, 4, 'Vanguard');
INSERT INTO role VALUES(5, 5, 'Vanguard');
INSERT INTO role VALUES(6, 6, 'Battlemage');
INSERT INTO role VALUES(7, 7, 'Burst');
INSERT INTO role VALUES(8, 8, 'Marksman');
INSERT INTO role VALUES(9, 9, 'Marksman');
INSERT INTO role VALUES(10, 10, 'Battlemage');
INSERT INTO role VALUES(11, 11, 'Specialist');
INSERT INTO role VALUES(12, 12, 'Catcher');
INSERT INTO role VALUES(13, 13, 'Catcher');
INSERT INTO role VALUES(14, 14, 'Burst');
INSERT INTO role VALUES(15, 15, 'Warden');
INSERT INTO role VALUES(16, 16, 'Marksman');
INSERT INTO role VALUES(17, 17, 'Diver');
INSERT INTO role VALUES(18, 18, 'Battlemage');
INSERT INTO role VALUES(19, 19, 'Specialist');
INSERT INTO role VALUES(20, 20, 'Marksman');

CREATE TABLE skin ( 
         SID INTEGER NOT NULL, 
         CID INTEGER NOT NULL, 
         SkinTheme TEXT NOT NULL, 
         Name TEXT NOT NULL, 
         Tier TEXT NOT NULL, 
         OEPrice INTEGER, 
         RPPrice INTEGER,
         Gemstones INTEGER NOT NULL,
         Unlockable INTEGER NOT NULL, 
         PRIMARY KEY(SID),
         FOREIGN KEY(CID) REFERENCES champions(CID) ON DELETE CASCADE
);
INSERT INTO skin VALUES(1, 2, 'Original', 'Original Ahri', 'Regular', NULL, 975, 0, 1);
INSERT INTO skin VALUES(2, 2, 'K/DA', 'K/DA Ahri', 'Epic', 1050, 1350, 0, 1);
INSERT INTO skin VALUES(3, 1, 'Mecha', 'Mecha Aatrox', 'Epic', 1050, 1350, 0, 1);
INSERT INTO skin VALUES(4, 1, 'Limitied', 'Victorious Aatrox', 'Limited', Null, Null, 1, 0);
INSERT INTO skin VALUES(5, 3, 'Original', 'Original Akali', 'Regular', Null, 790, 0, 1);
INSERT INTO skin VALUES(6, 3, 'Blood Moon','Blood Moon Akali', 'Regular', 675, 975, 0, 1);
INSERT INTO skin VALUES(7, 4, 'Original', 'Original Alistar', 'Regular', NULL, 585, 0, 1);
INSERT INTO skin VALUES(8, 4, 'Infernal', 'Infernal AListar', 'Regular', 675, 975, 0, 1);
INSERT INTO skin VALUES(9, 5, 'Original', 'Original Amumu', 'Regular', NULL, 260, 0, 1);
INSERT INTO skin VALUES(10, 5, 'Infernal', 'Infernal Amumu', 'Epic', 1050, 1350, 0, 1);
INSERT INTO skin VALUES(11, 6, 'Original', 'Original Anivia', 'Regular', NULL, 790, 0, 1);
INSERT INTO skin VALUES(12, 6, 'Papercraft', 'Papercraft Anivia', 'Epic', 1050, 1350, 0, 1);
INSERT INTO skin VALUES(13, 7, 'Original', 'Original Annie', 'Regular', NULL, 260, 0, 1);
INSERT INTO skin VALUES(14, 7, 'Super Galaxy', 'Super Galaxy Annie', 'Epic', 1050, 1350, 0,1);
INSERT INTO skin VALUES(15, 8, 'Original', 'Original Aphelios', 'Regular', NULL, 975, 0, 1);
INSERT INTO skin VALUES(16, 8, 'Nightbringer', 'Nightbringer Aphelios', 'Epic', 1050, 1350, 0, 1);
INSERT INTO skin VALUES(17, 9, 'Original', 'Original Ashe', 'Regular', NULL, 260, 0, 1);
INSERT INTO skin VALUES(18, 9, 'PROJECT','PROJECT Ashe', 'Legendary', 1520, 1820, 0, 1);
INSERT INTO skin VALUES(19, 10, 'Original', 'Original Aurelion Sol', 'Regular', NULL, 975, 0, 1);
INSERT INTO skin VALUES(20, 10, 'Infernal', 'Ashen Lord Aurelion Sol', 'Epic', 1050, 1350, 0, 1);
INSERT INTO skin VALUES(21, 11, 'Original', 'Original Azir', 'Regular', NULL, 880, 0, 1);
INSERT INTO skin VALUES(22, 11, 'Galactic', 'Galactic Azir','Regular', 675, 975, 0, 1);
INSERT INTO skin VALUES(23, 12, 'Original', 'Original Bard', 'Regular', Null, 975, 0, 1);
INSERT INTO skin VALUES(24, 12, 'Elderwood', 'Elderwood Bard', 'Regular', 675, 975, 0, 1);
INSERT INTO skin VALUES(25, 13, 'Original', 'Original Blitzcrank','Regular', NULL, 790, 0, 1);
INSERT INTO skin VALUES(26, 13, 'Program', 'iBlitzcrank', 'Epic', 1050, 1350, 0, 1);
INSERT INTO skin VALUES(27, 14, 'Original', 'Original Brand', 'Regular', NULL, 880, 0, 1);
INSERT INTO skin VALUES(28, 14, 'Arclight', 'Arclight Brand', 'Chroma', 1050, 1350, 0, 1);
INSERT INTO skin VALUES(29, 15, 'Original', 'Original Braum', 'Regular', NULL, 880,0, 1);
INSERT INTO skin VALUES(30, 15, 'Sugar Rush', 'Sugar Rush Braum', 'Epic', 1050, 1350, 0, 1);
INSERT INTO skin VALUES(31, 16, 'Original', 'Original Caitlyn', 'Regular', NULL, 880, 0, 1);
INSERT INTO skin VALUES(32, 16, 'Pulsefire', 'Pulsefire Caitlyn', 'Legendary', 1520, 1820, 0, 1);
INSERT INTO skin VALUES(33, 17, 'Original', 'Original Camille', 'Regular', NULL, 975, 0, 1);
INSERT INTO skin VALUES(34, 17, 'Program', 'Program Camille', 'Epic', 1050, 1350, 0, 1);
INSERT INTO skin VALUES(35, 18, 'Original', 'Original Cassiopeia', 'Regular', NULL, 880, 0, 1);
INSERT INTO skin VALUES(36, 18, 'High Noon', 'Desperada Cassiopeia', 'Regular', 220, 520, 0, 1);
INSERT INTO skin VALUES(37, 19, 'Original', 'Original Cho Gath', 'Regular', NULL, 585, 0, 1);
INSERT INTO skin VALUES(38, 19, 'High Society', 'Gentleman Cho Gath', 'Legendary', 1520, 1820, 0, 1);
INSERT INTO skin VALUES(39, 20, 'Original', 'Original Corki', 'Regular', NULL, 790, 0, 1);
INSERT INTO skin VALUES(40, 20, 'Arcade Heroes', 'Arcade Corki', 'Epic', 1050, 1350, 0, 1);


CREATE TABLE lane( 
         CID INTEGER NOT NULL,
         PID INTEGER NOT NULL, 
         Position TEXT NOT NULL,
		 PRIMARY KEY(PID),
         FOREIGN KEY(CID) REFERENCES champions(CID) ON DELETE CASCADE
 );
INSERT INTO lane VALUES(1, 1, 'Top');
INSERT INTO lane VALUES(1, 2, 'Middle');
INSERT INTO lane VALUES(2, 3, 'Middle');
INSERT INTO lane VALUES(3, 4, 'Top');
INSERT INTO lane VALUES(3, 5, 'Middle');
INSERT INTO lane VALUES(4, 6, 'Support');
INSERT INTO lane VALUES(5, 7, 'Jungle');
INSERT INTO lane VALUES(6, 8, 'Middle');
INSERT INTO lane VALUES(7, 9, 'Middle');
INSERT INTO lane VALUES(8, 10, 'Bottom');
INSERT INTO lane VALUES(9, 11, 'Bottom');
INSERT INTO lane VALUES(10, 12, 'Middle');
INSERT INTO lane VALUES(11, 13, 'Middle');
INSERT INTO lane VALUES(12, 14, 'Support');
INSERT INTO lane VALUES(13, 15, 'Support');
INSERT INTO lane VALUES(14, 16, 'Support');
INSERT INTO lane VALUES(15, 17, 'Support');
INSERT INTO lane VALUES(16, 18, 'Bottom');
INSERT INTO lane VALUES(17, 19, 'Top');
INSERT INTO lane VALUES(17, 20, 'Middle');
INSERT INTO lane VALUES(18, 21, 'Top');
INSERT INTO lane VALUES(18, 22, 'Middle');
INSERT INTO lane VALUES(19, 23, 'Top');
INSERT INTO lane VALUES(19, 24, 'Middle');
INSERT INTO lane VALUES(20, 25, 'Middle');

CREATE TABLE abilities( 
         CID INTEGER NOT NULL, 
         Q TEXT NOT NULL, 
         W TEXT NOT NULL, 
         E TEXT NOT NULL, 
         R TEXT NOT NULL,
         Passive TEXT NOT NULL,
		 PRIMARY KEY(CID),
         FOREIGN KEY(CID) REFERENCES champions(CID) ON DELETE CASCADE
 );
INSERT INTO abilities VALUES(1, 'The Darkin Blade', 'Infernal Chains', 'Umbral Dash', 'World Ender', 'Deathbringer Stance');
INSERT INTO abilities VALUES(2, 'Orb of Deception', 'Fox-Fire', 'Charm', 'Spirit Rush', 'Essence Theft');
INSERT INTO abilities VALUES(3, 'Five Point Strike', 'Twilight Shroud', 'Shuriken Flip', 'Perfect Execution', 'Assassins Mark');
INSERT INTO abilities VALUES(4, 'Pulverize', 'Headbutt', 'Trample', 'Unbreakable Will', 'Triumphant Roar');
INSERT INTO abilities VALUES(5, 'Bandage Toss', 'Despair', 'Tantrum', 'Curse of the Sad Mummy', 'Cursed Touch');
INSERT INTO abilities VALUES(6, 'Flash Frost', 'Crystallize', 'Frostbite', 'Glacial Storm', 'Rebirth');
INSERT INTO abilities VALUES(7, 'Disintegrate', 'Incinerate', 'Molten Shield', 'Summon: Tibbers', 'Pyromania');
INSERT INTO abilities VALUES(8, 'Weapon Abilities', 'Phase', 'Weapon Queue System', 'Moonlight Vigil', 'The Hitman and the Seer');
INSERT INTO abilities VALUES(9, 'Rangers Focus', 'Volley', 'Hawkshot', 'Enchanted Crystal Arrow', 'Frost Shot');
INSERT INTO abilities VALUES(10, 'Starsurge', 'Celestial Expansion', 'Comet of Legend', 'Voice of Light', 'Center of the Universe');
INSERT INTO abilities VALUES(11, 'Conquering Sands', 'Arise!', 'Shifting Sands', 'Emperors Divide', 'Shurimas Legacy');
INSERT INTO abilities VALUES(12, 'Cosmic Binding', 'Caretakers Shrine', 'Magical Journey', 'Tempered Fate', 'Travelers Call');
INSERT INTO abilities VALUES(13, 'Rocket Grab', 'Overdrive', 'Power Fist', 'Static Field', 'Mana Barrier');
INSERT INTO abilities VALUES(14, 'Sear', 'Pillar of Flame', 'Conflagration', 'Pyroclasm', 'Blaze');
INSERT INTO abilities VALUES(15, 'Winters Bite', 'Stand Behind Me', 'Unbreakable', 'Glacial Fissure', 'Concussive Blows');
INSERT INTO abilities VALUES(16, 'Piltover Peacemaker', 'Yordle Snap Trap', '90 Caliber Net', 'Ace in the Hole', 'Headshot');
INSERT INTO abilities VALUES(17, 'Precision Protocol', 'Tactical Sweep', 'Hookshot', 'The Hextech Ultimatum', 'Adaptive Defenses');
INSERT INTO abilities VALUES(18, 'Noxious Blast', 'Miasma', 'Twin Fang', 'Petrifying Gaze', 'Serperntine Grace');
INSERT INTO abilities VALUES(19, 'Rupture', 'Feral Scream', 'Vorpal Spikes', 'Feast', 'Carnivore');
INSERT INTO abilities VALUES(20, 'Phosphorus Bomb', 'Valkyrie', 'Gatling Gun', 'Missile Barrage', 'Hextech Munitions');
COMMIT;